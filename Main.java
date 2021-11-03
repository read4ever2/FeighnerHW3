class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            LoopPrinter threadPrinter = new LoopPrinter(Integer.toString(i));
            threadPrinter.start();
        }
    }
}