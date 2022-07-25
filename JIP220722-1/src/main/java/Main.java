public class Main {
    public static void firstProgram() {
        Employee employee = new Employee("enes", "ergen", "personel", 1999);
        Employee employee1 = new Employee("ahmet", "yıldız", "personel", 1999);
        Employee employee2 = new Employee("emre", "koç", "personel", 1999);
        Employee employee3 = new Employee("kısmet", "tok", "personel", 1999);
        Employee employee4 = new Employee("özgür", "kıdem", "personel", 1999);
        Employee employee5 = new Employee("ozan", "selçuk", "personel", 1999);
        Employee employee6 = new Employee("gizem", "atıl", "personel", 1999);
        Employee employee7 = new Employee("ece", "önder", "personel", 1999);
        Employee employee8 = new Employee("hilal", "yıldız", "personel", 1999);
        Employee employee9 = new Employee("nur", "hayi", "personel", 1999);
        DpOperations.insertEmployee(employee);
        DpOperations.insertEmployee(employee1);
        DpOperations.insertEmployee(employee2);
        DpOperations.insertEmployee(employee3);
        DpOperations.insertEmployee(employee4);
        DpOperations.insertEmployee(employee5);
        DpOperations.insertEmployee(employee6);
        DpOperations.insertEmployee(employee7);
        DpOperations.insertEmployee(employee8);
        DpOperations.insertEmployee(employee9);

    }

    public static void secondProgram(){
        for (Employee employee:DpOperations.getAllEmployee(OrderFiled.BIRTHYEAR)
             ) {
            System.out.println(employee.getName());
        }
    }

    public static void main(String[] args) {
    secondProgram();

    }
}
