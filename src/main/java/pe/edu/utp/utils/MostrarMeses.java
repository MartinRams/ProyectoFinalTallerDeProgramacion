package pe.edu.utp.utils;

public class MostrarMeses {
    private int monthNumber;
    
    public MostrarMeses() {}
    
    public MostrarMeses(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonthString() {
        String[] monthNames = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
            "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
        };

        if (monthNumber >= 1 && monthNumber <= 12) {
            return monthNames[monthNumber-1];
        }else{
             return "Opcion Invalida";
        }
    }
    
    public static void mostrarMeses() {
        String separadorMeses = "==================\n";
        String[] meses = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
            "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE","VOLVER"
        };
        
        System.out.println(separadorMeses);
        for (int i = 0; i < meses.length; i++) {
           if (i==12){
                System.out.printf("[ 0 ]  %-11s%n", meses[i]);
            }else {
                System.out.printf("[ %-2d]  %-11s%n", (i + 1), meses[i]);
            }
        }
        System.out.println(separadorMeses);
    }
}
