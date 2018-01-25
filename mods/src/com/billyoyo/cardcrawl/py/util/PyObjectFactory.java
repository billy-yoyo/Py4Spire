package com.billyoyo.cardcrawl.py.util;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Created by william on 24/01/2018.
 */
public class PyObjectFactory {

    private final Class interfaceType;
    private final PyObject pyClass;

    public PyObjectFactory(Class interfaceType, String pkg, String className) {
        this.interfaceType = interfaceType;
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from " + pkg + " import " + className);
        pyClass = interpreter.get(className);
    }

    public <T> T create() {
        return (T) pyClass.__call__().__tojava__(interfaceType);
    }

}
