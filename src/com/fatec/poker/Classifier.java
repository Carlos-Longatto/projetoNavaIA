package com.fatec.poker;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.*;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class Classifier {

    public String classify(double[] cartas) throws Exception {
        ConverterUtils.DataSource arquivo = new ConverterUtils.DataSource("data/poker-teste2.arff");
        Instances dados = arquivo.getDataSet();

        //String[] parametros = new String[]{};
        Remove filtro = new Remove();
       // filtro.setOptions(parametros);
        filtro.setInputFormat(dados);
        dados = Filter.useFilter(dados, filtro);
       // System.out.println("passei aqui 1");

        AttributeSelection selAtributo = new AttributeSelection();
        InfoGainAttributeEval avaliador = new InfoGainAttributeEval();
        Ranker busca = new Ranker();
        selAtributo.setEvaluator(avaliador);
        selAtributo.setSearch(busca);
        selAtributo.SelectAttributes(dados);
       // System.out.println("passei aqui 2");

        String[] opcoes = new String[1];
        opcoes[0] = "-U";
        J48 arvore = new J48();
        arvore.setOptions(opcoes);
        arvore.buildClassifier(dados);
       // System.out.println("passei aqui 3");

        // Criar uma instância baseada nestes atributos
        Instance instance = new DenseInstance(1, cartas);

        // Adicionar a instância nos dados
        instance.setDataset(dados);

        // Classificar esta nova instância
        double label = arvore.classifyInstance(instance);
        //System.out.println("passei aqui 4");

        weka.classifiers.Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(dados);
        eval_roc.crossValidateModel(cl, dados, 2, new Debug.Random(1), new Object[] {});
        System.out.println(eval_roc.toSummaryString());
        //System.out.println("passei aqui 5");

        return dados.classAttribute().value((int) label);

    }
}
