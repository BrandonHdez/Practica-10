public class main {
    public static void main(String[] args) {
        int op;
        Zoo zoo = new Zoo();
        do{
            System.out.println("Elegir opcion ");
            System.out.println("1) Añadir");
            System.out.println("2) Eliminar");
            System.out.println("3) Mostrar");
            System.out.println("4) Salir");
            op = CapturaEntrada.capturaEntero("Opcion");
            switch(op){
                case 1:{
                    zoo.agregar(CapturaEntrada.capturaCadena("Agregar"));
                    break;
                }
                case 2:{
                    zoo.quitar();
                    break;
                }
                case 3:{
                    zoo.imprimir();
                    break;
                }
            }
        }while(op!=4);
    }
}

import java.util.Scanner;

public class CapturaEntrada {

    public static int capturaEntero(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextInt());
    }
    public static float capturaFlotante(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextFloat());
    }
    public static double capturaDoble(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextDouble());
    }

    public static String capturaCadena(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }
}
public class Veterinarian {
    private String nombre;
    private double sueldo;
    private int age;

    public Veterinarian(String nombre, double salario){
        setSalario(salario);
        setNombre(nombre);
    }

    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(String age){
        this.age = age;
    }

    public double getSalario(){
        return salario;
    }
    public String getNombre(){
        return nombre;
    }
    public int  getAge(){
        return age;
    }

    public void vacunar(Animall){
        a.setVacuna(true);
    }

    public void revisar(Animall){
        if(a.vacuna){
            System.out.println(a.nombre + "esta vacunado");
        }
        else{
            System.out.println(a.nombre + "no esta vacunado");
        }
    }
}

import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animal> animales = new ArrayList<>();
    private Veterinarian v = new Veterinarian(CapturaEntrada.capturaCadena("Nombre del veterinari@"),CapturaEntrada.capturaDoble("Sueldo?"));

    public void agregar(String animal){
        animal = animal.trim().toLowerCase();
        Animal a = null;
        switch(animal){
            case "perro" -> {
                a = new Dog(CapturaEntrada.capturaCadena("Nombre"),CapturaEntrada.capturaEntero("Edad"));
                break;
            }
            case "gato" -> {
                a = new Cat(CapturaEntrada.capturaCadena("Nombre"),CapturaEntrada.capturaEntero("Edad"));
                break;
            }
            default -> {
                System.out.println("Error, volver a intentar");
            }
        }
        if(a != null){
            animales.add(a);
        }
    }

    public void imprimir(){
        for(Animal a: animales){
            a.eat();
            v.vacunar(a);
            v.revisar(a);
            if(a instanceof Dog){
                ((Dog)a).ladrar();
            }
            else(a instanceof Cat){
                ((Cat)a).aruñar();
            }
            System.out.println();
        }
    }

    public void quitar(){
        int i = 1, op;

        for(Animal a: animales){

            System.out.println("Numero de animal: " + i);
            System.out.print(a.nombre + "\n");
            i++;
        }
        op = CapturaEntrada.capturaEntero("Introducir el numero: ");
        animales.remove((op-1));
        System.out.println("Animal borrado.");
    }
}

public class Animal {
    private String name;
    private int age;
    private boolean vacunado, revisionGeneral;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public void eat() {
        System.out.println(getName() + "Esta comiendo");
    }

    public void sleep() {
        System.out.println(getName() + "Esta despierto");
    }

    @Override
    public String toString() {
        return "            name: " + name + "      age: " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    public boolean isRevisionGeneral() {
        return revisionGeneral;
    }

    public void setRevisionGeneral(boolean revisionGeneral) {
        this.revisionGeneral = revisionGeneral;
    }
}   

public class Gato extends Animal {

    public Gato(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " El esta comiendo");
    }
}

public class Perro extends Animal {

    public Perro(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " El esta comiendo");
    }
}