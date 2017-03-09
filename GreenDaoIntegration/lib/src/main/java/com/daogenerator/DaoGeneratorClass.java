package com.daogenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * author rajkat
 * github.com/rajkat
 */
public class DaoGeneratorClass {

    private static final int SCHEMA_VERSION = 1;
    private static final String DEFAULT_JAVA_PACKAGE = "tg.myapps.rajkat.greendaointegration.model";
    private static final String DEFAULT_JAVA_PACKAGE_DAO = "tg.myapps.rajkat.greendaointegration.model.dao";
    private static final String DEFAULT_JAVA_PACKAGE_TEST = "tg.myapps.rajkat.greendaointegration.model.test";
    private static final String OUT_DIR = "app/src/main/java";

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(SCHEMA_VERSION, DEFAULT_JAVA_PACKAGE);

        schema.setDefaultJavaPackageDao(DEFAULT_JAVA_PACKAGE_DAO);
        schema.setDefaultJavaPackageTest(DEFAULT_JAVA_PACKAGE_TEST);

        addPersonEntity(schema);

        new DaoGenerator().generateAll(schema, OUT_DIR);
    }

    /**
     * Person entity method
     * @param schema
     */
    private static void addPersonEntity(Schema schema){
        Entity person = schema.addEntity("Person");
        person.implementsSerializable();
        person.addIdProperty();
        person.addStringProperty("firstname");
        person.addStringProperty("lastname");
        person.addStringProperty("username");
    }
}
