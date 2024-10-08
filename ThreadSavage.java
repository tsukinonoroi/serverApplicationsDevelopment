package org.example;

class ThreadSavage extends Thread {
    private int id;

    public ThreadSavage(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.lock) {
                    while (Main.pot == 0) {
                        System.out.println("Дикарь " + id + " ждет, потому что кастрюля пуста.");
                        Main.lock.wait();
                    }

                    Main.pot--;
                    System.out.println("Дикарь " + id + " поел");

                    if (Main.pot == 0) {
                        Main.lock.notifyAll();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


