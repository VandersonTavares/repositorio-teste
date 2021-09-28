package empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.Category.FORMAT, Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Funcionario> list = new ArrayList<>();

        System.out.print("How many employees will be registred? ");
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < t; i++) {     
            System.out.println("Employee #"+ (i+1));
            System.out.print("Id: ");
            int id = sc.nextInt();          

            while(hasId(list,id)){
                System.out.print("Id already taken. Try again: ");
		id = sc.nextInt();
            }
            sc.nextLine();
            System.out.print("Name: ");
            String n = sc.nextLine();
            System.out.print("Salary: ");
            double s = sc.nextDouble();
            
            /*
            Funcionario f = new Funcionario(id,n,s);
            list.add(f);
            */
            
            list.add(new Funcionario(id, n, s));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        //faz a busca do id digitado e joga o resultado na variavel emp
        Funcionario emp = list.stream().filter(x-> x.getId()==id).findFirst().orElse(null);
                
        if(emp == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.println("Enter Percentage: ");
            double porcentagem = sc.nextDouble();
            emp.aumento(porcentagem);
        }
        
        System.out.println();
        System.out.println("List of Empoyees");
        for(Funcionario obj: list){
            System.out.println(obj);
        }
 
        
        sc.close();   
    }
    
        public static boolean hasId(List<Funcionario> list, int id) {
	Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            return emp != null;
	}
    
}
