package com.company;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
	    lineLaptopModels modelsLine = new lineLaptopModels();
        modelsLine.addModelNotebook(900,32,500,16);
        modelsLine.addModelNotebook(300,4,400,14);
        modelsLine.addModelNotebook(1000,16,500,15);
        modelsLine.addModelNotebook(1100,8,256,13);
        modelsLine.addModelNotebook(1100,8,256,13);
        modelsLine.addModelNotebook(1100,8,256,13);
        modelsLine.addModelNotebook(1100,16,256,13);
        logger.info(modelsLine.searchModels());
    }
}
