public enum OrderFiled {
    NAME("name"), SURNAME("surname"), BIRTHYEAR("birthyear");

    private String orderField;

    OrderFiled(String orderField) {
        this.orderField = orderField;
    }
    public String getOrderField(){
        return this.orderField;
    }
}
