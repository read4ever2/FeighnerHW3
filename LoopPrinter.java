class LoopPrinter implements Runnable {

    private String name;

    LoopPrinter(String nameString) {
        nameString = this.name;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) {
            System.out.print("This is thread " + this.name.toString() + " . This is interation " + i);
            Thread.sleep(5);
            
        }
    }
}