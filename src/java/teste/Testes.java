/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

//import Model.Colaborador;
import Model.Teste;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

//import business_rules.ColaboradorRules;
//import business_rules.EventoRules;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Timer;
//import java.util.TimerTask;
//import javax.mail.internet.MimeMessage;
/**
 *
 * @author Mayk Willians
 */
public class Testes {

//    public static final long TEMPO = (1000 * 2); // atualiza o site a cada 1 minuto
    public static void main(String[] args) throws ParseException {
        
        
        String str = "102345 - tfygvjhbj";
        
        int tipo = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        
        System.out.println(tipo);
        
//        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
//
//        String senha = "";
//
//        for (int x = 0; x < 6; x++) {
//            
//            int j = (int) (Math.random() * carct.length);
//            senha += carct[j];
//        }
        
//        System.out.println(senha);
        
//        String textoAux = "vai T";
//
//        String pesquisaAux = "VaI";
//        
//        String texto = textoAux.toLowerCase();
//        String pesquisa = pesquisaAux.toLowerCase();
//        
//        if (texto.contains(pesquisa)) {
//        
//            // Só tem ela no texto
//            if (pesquisa.length() == texto.length()) {
//
//                System.out.println("Só tem ela!");
//            } else {
//
//                int ocorrencia = texto.indexOf(pesquisa);
//
//                if ((ocorrencia == 0)) {
//
//                    if (texto.substring(pesquisa.length(), pesquisa.length() + 1).equals(" ")) {
//                        
//                        System.out.println("Achou no começo, mas tem mais coisa depois!");
//                    }
//                } else {
//
//                    int parte = ocorrencia + pesquisa.length();
//                    
//                    if (parte == texto.length()) {
//                        
//                        if (texto.substring(ocorrencia - 1, ocorrencia).equals(" ")) {
//
//                            System.out.println("Achou no final!");
//                        }
//                    } else {
//                        
//                        if ((texto.substring(ocorrencia - 1, ocorrencia).equals(" ")) && (texto.substring(ocorrencia + pesquisa.length(), (ocorrencia + pesquisa.length()) + 1).equals(" "))) {
//
//                            System.out.println("Achou entre o texto!");
//                        }
//                    }
//                }
//            }
//        } else {
//            
//            System.out.println("NÃO ENCONTRADO!");
//        }
        
//        String antes = texto.substring(x - 1, x);
//            String depois = texto.substring(x + procurada.length(), (x + procurada.length() + 1));
//        
//        if ((antes.equals("") || antes.equals(" ")) && (depois.equals("") || depois.equals(" "))) {
//            
//            System.out.println("Achou!");
//        }
        
//        Teste t1 = new Teste ("Escola", "16/04/2018", 1);
//        Teste t2 = new Teste ("Trabalho", "25/04/2023", 1);
//        Teste t3 = new Teste ("Jogo", "01/04/2000", 1);
//        Teste t4 = new Teste ("Trilha", "22/04/2012", 1);
//        Teste t5 = new Teste ("Namoro", "14/04/2055", 1);
//        List<Teste> lista = new ArrayList<>();
//        lista.add(t1);
//        lista.add(t2);
//        lista.add(t3);
//        lista.add(t4);
//        lista.add(t5);
//        
//        for (Teste t : lista) {
//            
//            if (passou(t.getData())) {
//                
//                t.setStatus(-1);
//            }
//        }
//        
//        for (Teste t : lista) {
//
//            if (t.getStatus() == -1) {
//                
//                System.out.println(t.getNome());
//                System.out.println(t.getData());
//                System.out.println();
//            }
//        }
        
//        Teste t1 = new Teste ("Escola", "12/04/2018", 1);
//        Teste t2 = new Teste ("Trabalho", "12/04/2023", 1);
//        Teste t3 = new Teste ("Jogo", "12/04/2000", 1);
//        Teste t4 = new Teste ("Trilha", "12/04/2012", 1);
//        Teste t5 = new Teste ("Namoro", "12/04/2014", 1);
//        
//        List<Teste> lista = new ArrayList<>();
//        lista.add(t1);
//        lista.add(t2);
//        lista.add(t3);
//        lista.add(t4);
//        lista.add(t5);
//
//        Comparator<Teste> order = new Comparator<Teste>() {
//
//            public int compare(Teste obj1, Teste obj2) {
//
//                String a = obj1.getData();
//                String b = obj2.getData();
//
//                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//                Date data1 = null;
//                try {
//                    data1 = new Date(format.parse(a).getTime());
//                } catch (ParseException ex) {
//                    Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                Date data2 = null;
//                try {
//                    data2 = new Date(format.parse(b).getTime());
//                } catch (ParseException ex) {
//                    Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                if (data1.after(data2)) {
//
//                    return 1;
//                } else {
//
//                    if (data1.before(data2)) {
//
//                        return -1;
//                    }
//                }
//
//                return 0;
//            }
//        };
//
//        Collections.sort(lista, order); // pronto agora sua lista esta ordenada
//        
//        for (Teste t : lista) {
//
//            System.out.println(t.getNome());
//            System.out.println(t.getData());
//            System.out.println();
//        }
        
//        String a = "12/04/2019";
//        String b = "14/04/2018";
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date data1 = new Date(format.parse(a).getTime());
//        Date data2 = new Date(format.parse(b).getTime());
//        if (data1.after(data2)) {
//            System.out.println("Data: " + a + " é posterior à " + b);
//        } else if (data1.before(data2)) {
//            System.out.println("Data: " + a + " é inferior à " + b);
//        } else {
//            System.out.println("Data: " + a + " é igual à " + b);
//        }
        
//        for (Integer n : lista) {
//            
//            System.out.println(n);
//        }
        
//        DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
//        
//        Date date1 = null;
//        Date date2 = null;
//        Date date3 = null;
//        Date date4 = null;
//        Date date5 = null;
//        try {
//            date1 = (Date)formatter.parse("01/11/2018");
//            date2 = (Date)formatter.parse("05/11/2055");
//            date3 = (Date)formatter.parse("10/11/2018");
//            date4 = (Date)formatter.parse("01/11/2018");
//            date5 = (Date)formatter.parse("13/11/2000");
//        } catch (ParseException ex) {
//            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        List<Date> myList = new ArrayList();
//        myList.add(date1);
//        myList.add(date2);
//        myList.add(date3);
//        myList.add(date4);
//        myList.add(date5);
//        
//        Collections.sort(myList, new Comparator<DateTime>() {
//            public int compare(DateTime o1, DateTime o2) {
//                return o1.getDateTime().compareTo(o2.getDateTime());
//            }
//        });
        
//        ArrayList genericList = new ArrayList();
//        
//        ArrayList<Object> strList = new ArrayList<Object>();
//        ArrayList<Object> strList2 = new ArrayList<Object>();
//        ArrayList<Object> strList3 = new ArrayList<Object>();
//        
//        
//        
//        strList.add(new Object());
//        strList.add(new Object());
//        strList.add(new Object());
//        
//        strList2.add(new Object());
//        strList2.add(new Object());
//        strList2.add(new Object());
//        
////        genericList.add("cachorro");
//
//        genericList.add(strList);
//        genericList.add(strList2);
//        
//        for (Object obj : genericList) {
//            
//            for (Object str : (ArrayList) obj) {
//                strList3.add(str);
//            }
//        }
//        
//        System.out.println(strList3.size());
        
//        String dates[] = {"12/04/2018", "12/04/2018", "12/04/2018", "12/04/2018", "12/04/2018", "12/04/2018"};
//        Arrays.sort(dates, new Comparator<String>() {
//            private SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
//            @Override
//            public int compare(String o1, String o2) {
//                int result = -1;
//
//                try {
//                    result = sdf.parse(o1).compareTo(sdf.parse(o2));
//                } catch (ParseException ex) {
//                    ex.printStackTrace();
//                }
//
//                return result;
//            }
//        });
//
//        for (String date : dates) {
//            System.out.println(date);
//        }





//        ArrayList<String> datestring = new ArrayList<String>();
//        datestring.add("04/03/2018");
//        datestring.add("04/03/2018");
//        datestring.add("11/03/2018");
//        datestring.add("11/03/2018");
//        datestring.add("04/03/2018");
//        datestring.add("11/03/2018");
//        datestring.add("04/03/2018");
//        datestring.add("04/03/2018");
//
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        Map <Date, String> dateFormatMap = new TreeMap<>();
//        for (String date: datestring) {
//            try {
//                dateFormatMap.put(f.parse(date), date);
//            } catch (ParseException ex) {
//                Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        for (String s : dateFormatMap.values()) {
//            System.out.println(s);
//        }





//        String s = "-0";
//        try{
//            Integer.parseInt(s);
//            System.out.println("é numero");
//        }catch(Exception e){
//            System.out.println("NÃO é numero");
//        }
//        int delay = 0;   // delay for 5 sec.
//        int period = 3000;  // repeat every sec.
//        Timer timer = new Timer();
//
//        timer.scheduleAtFixedRate(new TimerTask() {
//                public void run() {
//                    System.out.println("OK");
//                }
//            }, delay, period);
//        File file = new File("build/web/img/folders_eventos/2_0.png");
//        if (file.exists()) {
//
//            System.out.println("OK");
//
//        }
//        File file = new File("build/web/img/folders_eventos/1_1.png");
//        
//        if (file.exists()) {
//            
//            System.out.println("OK");
//        }
//        Colaborador colaborador = new ColaboradorRules().getOneForID(1);
//        
//        EventoRules eventoRules = new EventoRules();
//        
//        int qtdEvt = eventoRules.listByIdColaborador(colaborador.getId()).size();
//        
//        System.out.println(qtdEvt);
//        try {
//            Thread.sleep(3000);
//            System.out.println("Deu erro!");
//        } catch (Exception e) {
//            
//        }
//        final long time = 1000; // a cada X ms
//        Timer timer = new Timer();
//        TimerTask tarefa = new TimerTask() {
//                public void run() {
//                       //método
//                        try {
//                                System.out.println("teste");
//                        } catch (Exception e) {
//                                e.printStackTrace();
//                        }
//                }
//        };
//        timer.scheduleAtFixedRate(tarefa, time, time);
//        timer.schedule(tarefa, time);
//        timer.cancel();
//        String x = "1*124332";
//        
//        int a = Integer.parseInt(x.substring(0, 1));
//        int b = Integer.parseInt(x.substring(2, x.length()));
//        
//        System.out.println(a);
//        System.out.println(b);
//        String hora = "12:12";
//        
//        int horasEmMinutos = Integer.parseInt(hora.substring(0, 2)) * 60;
//        int minutos = Integer.parseInt(hora.substring(3, hora.length()));
//        
//        int minutosTotal = horasEmMinutos + minutos;
//        
//        
//        int a = minutosTotal % 60;
//        int b = minutosTotal / 60;
//        
//        String x = a + "";
//        String y = b + "";
//        
//        String k = x;
//        String l = y;
//        
//        if (x.length() == 1) {
//            
//            k = "0" + x;
//        }
//        
//        if (y.length() == 1) {
//            
//            l = "0" + y;
//        }
//        
//        String horaCerta = l + ":" + k;
//        
//        System.out.println(horaCerta);
//        String hora = "01:25";
//        
//        int horasEmMinutos = Integer.parseInt(hora.substring(0, 2)) * 60;
//        int minutos = Integer.parseInt(hora.substring(3, hora.length()));
//        
//        int minutosTotal = horasEmMinutos + minutos;
//                
//        System.out.println(horasEmMinutos);
//        System.out.println(minutos);
//        System.out.println(minutosTotal);
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(formatador.format(data));
//        String data_e_hora = "2018-11-24T22:15";
//        
//        // Tratamento da data do evento
//        String dataAux = data_e_hora.substring(0, 10);
//        String dia = dataAux.substring(8, 10);
//        String mes = dataAux.substring(5, 7);
//        String ano = dataAux.substring(0, 4);
//        String data = dia + "/" + mes + "/" + ano;
//        // Tratamento da data do evento
//        String hora = data_e_hora.substring(11, data_e_hora.length());
//        
//        System.out.println(data);
//        System.out.println(hora);
//        String str = "2018-11-24T22:15";
//        
//        String dataAux = str.substring(0, 10);
//        String dia = dataAux.substring(8, 10);
//        String mes = dataAux.substring(5, 7);
//        String ano = dataAux.substring(0, 4);
//        String data = dia + "/" + mes + "/" + ano;
//        
//        String hora = str.substring(11, str.length());
//        
//        System.out.println(data);
//        System.out.println(hora);
    }
    
    public static boolean passou (String dataAux) {
        
        String data = dataAux;
        
        Calendar dataHojeAux = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(dataHojeAux.getTime());
        String hoje = dataHoje;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date dataDoEvt = null;
        try {
            dataDoEvt = new Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataDeHoje = null;
        try {
            dataDeHoje = new Date(format.parse(hoje).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataDoEvt.after(dataDeHoje)) {

            return false;
        } else {

            if (dataDoEvt.before(dataDeHoje)) {

                return true;
            }
        }

        return false;
    }
}
