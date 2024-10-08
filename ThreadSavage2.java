package org.example;

public class ThreadSavage2 extends Thread {
    private int id;
    private boolean fed;

    public ThreadSavage2(int id, boolean fed) {
        this.id = id;
        this.fed = fed;
    }

    public ThreadSavage2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.lock) {

                    for (int i = 0; i < Main.savages.size(); i++) {
                        if (!Main.savages.get(i).isFed()) {
                            while (Main.pot == 0) {
                                Main.lock.wait();
                            }
                            if (Main.pot > 0 && !Main.savages.get(i).isFed()) {
                                Main.pot--;
                                Main.savages.get(i).setFed(true);
                                System.out.println("Дикарь " + i + " съел порцию, в кастрюле осталось " + Main.pot + " порций");

                                if (allSavagesFed()) {
                                    System.out.println("\u001B[32m"+"Все дикари поели."+"\u001B[0m");
                                    resetFed();
                                }

                                if (Main.pot == 0) {
                                    Main.lock.notifyAll();
                                }
                            }

                        }
                    }
                    Thread.sleep(10000);

                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean allSavagesFed() {
        for (ThreadSavage2 savage : Main.savages) {
            if (!savage.isFed())
                return false;
        }
        return true;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }

    public boolean isFed() {
        return fed;
    }

    public void resetFed() {
        for (ThreadSavage2 savage : Main.savages) {
            savage.setFed(false);
        }
    }
}
