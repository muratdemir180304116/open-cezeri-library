/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.deep_learning.ai.djl.examples.denemeler.mnist;

import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.modality.cv.translator.ImageClassificationTranslator;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import cezeri.factory.FactoryUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Uses the model to generate a prediction called an inference
 */
public class Inference {
    public static void main(String[] args) throws ModelException, TranslateException, IOException {
        String[] lbl={"0","1","2","3","4","5","6","7","8","9"};
        // the location where the model is saved
        Path modelDir = Paths.get("models");
        System.setProperty("DJL_CACHE_DIR", "c:/ai/djl");
        // the path of image to classify
        String imageFilePath;
        // Load the image file from the path
        Image img = null;//ImageFactory.getInstance().fromFile(Paths.get(imageFilePath));

        try (Model model = Models.getModel(Models.NUM_OF_OUTPUT, Models.IMAGE_WIDTH, Models.IMAGE_HEIGHT)) { // empty model instance
            // load the model
            model.load(modelDir, Models.MODEL_NAME);

            // define a translator for pre and post processing
            // out of the box this translator converts images to ResNet friendly ResNet 18 shape
            Translator<Image, Classifications> translator
                    = ImageClassificationTranslator.builder()
                            .addTransform(new Resize(Models.IMAGE_WIDTH, Models.IMAGE_HEIGHT))
                            .addTransform(new ToTensor())
                            .optApplySoftmax(true)
                            .build();

            // run the inference using a Predictor
            int totImg = 0;
            int nErr = 0;
            try (Predictor<Image, Classifications> predictor = model.newPredictor(translator)) {
                // holds the probability score per label
                String basePath = "c:/ai/djl/mnist_test/";
                for (int i = 0; i < Models.NUM_OF_OUTPUT; i++) {
                    String imgPath=basePath+lbl[i];
                    
                    File[] imgFiles = FactoryUtils.getFileListInFolderForImages(imgPath);
                    for (File imgFile : imgFiles) {
                        totImg++;
                        img = ImageFactory.getInstance().fromFile(Paths.get(imgFile.getAbsolutePath()));
                        long t1=FactoryUtils.tic();
                        Classifications predictResult = predictor.predict(img);
                        t1=FactoryUtils.toc(t1);
                        //System.out.println(predictResult);
                        String predictedLabel = predictResult.topK(1).toString().split(",")[0].split(":")[1].replace('"', ' ').trim();
                        if (!predictedLabel.equals(lbl[i])) {
                            nErr++;
                            System.out.println("classificiation error at:" + i + " -> " + predictedLabel + " img:" + imgFile.getName());
                        }else{
                            System.out.println("hit at:" + i + " -> " + predictedLabel + " img:" + imgFile.getAbsolutePath());
                        }
                        //System.out.println(i+".class:"+predictedNum);
//                        System.out.println(predictResult);
                    }
                }
            }
            System.out.println("total test case:"+totImg+" accuracy ratio:" + (totImg-nErr)*1.0/totImg*100);
        }
    }
}
