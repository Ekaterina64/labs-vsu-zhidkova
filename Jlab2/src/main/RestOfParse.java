class RestOfParse {
    public double acc; // Аккумулятор
    public String rest; // остаток строки, которую мы еще не обработали

    public RestOfParse(double v, String r) {
        this.acc = v;
        this.rest = r;
    }
}