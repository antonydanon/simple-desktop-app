package com.desktop.simple_app.first_task;

public class InstanceCounter {
    private static int instanceCount;

    public InstanceCounter(){
        instanceCount++;
    }

    public static int getInstanceCount(){
        return instanceCount;
    }

    public static void main(String[] args) {
        InstanceCounter i1 = new InstanceCounter();
        InstanceCounter i2 = new InstanceCounter();
        System.out.println(getInstanceCount());

        InstanceCounter i3 = new InstanceCounter();
        System.out.println(getInstanceCount());
    }
}
