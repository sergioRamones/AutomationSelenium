package javaMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Arreglos {
	
	private int numero1;
	private int numero2;
	

	/**
	 * @Description Constructor sin parametros
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A
	 * @return N/A
	 */
	public Arreglos() {
		
	}
	
	/**
	 * @Description Constructor con dos parametros
	 * @author sramones
	 * @date 05/03/2022
	 * @param int, int
	 * @return N/A
	 */
	public Arreglos(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	/**
	 * @Description regresa el valor del numero 1
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A
	 * @return int
	 */
	public int getNumero1() {
		return numero1;
	}
	
	/**
	 * @Description regresa el valor del numero 2
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A
	 * @return int
	 */
	public int getNumero2() {
		return numero2;
	}

	/**
	 * @Description Inicializa el valor del numero1
	 * @author sramones
	 * @date 05/03/2022
	 * @param int
	 * @return N/A
	 */
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	/**
	 * @Description Inicializa el valor del numero2
	 * @author sramones
	 * @date 05/03/2022
	 * @param int
	 * @return N/A
	 */
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	
	/**
	 * @Description Crear arreglo y asignarle valor mostrar en consola valores
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A 
	 * @return N/A
	 */
	public void crearArreglo() {
		int[] arreglo1 = {1,2,3,4};
		
						
		for(int i=0 ; i<arreglo1.length ; i++) {
			
			System.out.println("El valor del arreglo 1 es: "+ arreglo1[i]);
		}
		
		// arreglo2 = {0,0,0,0,0,0,0};
		int[] arreglo2 = new int [9];
		
		int index = 1;
		System.out.println("\n");
		for (int i = 0; i < arreglo2.length; i++) {
			
			arreglo2[i] =  index*2;
			index++;
			System.out.println("El valor del arreglo 2 es: " + arreglo2[i]);
		}
		
		int suma = 0;
		System.out.println("\n");
		for(int i= 0 ; i<arreglo1.length ; i++) {
			suma = suma + arreglo1[i];
		}
		
		System.out.println("El valor de la sumatoria del primer arreglo es: " + suma);
		
		int suma2=0;
		
		for(int i=0 ; i<arreglo2.length ; i++) {
			suma2 = suma2 + arreglo2[i];
		}
		
		System.out.println("El valor de la sumatoria del segundo arreglo es: " + suma2);
		
	}
	
	
	/**
	 * @Description Invertir el orden de un arreglo
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A 
	 * @return N/A
	 */
	public void invertirOrdernArreglo() {
		int[] arreglo1 = {1,2,3,4,5};
		int[] arreglo2 = new int [arreglo1.length];
		
		for(int i=0 ; i<arreglo1.length ;i++) {
			System.out.println("El valor del arreglo1 es: [ "+ arreglo1[i]+" ]");
		}
		
		int index = arreglo1.length-1;
		
		for(int i=0 ; i<arreglo1.length ; i++) {
			
			System.out.println("El valor Invertido del arreglo1 es: [ "+ arreglo1[index]+" ]");
			index--;
		}
		
		for(int i = (arreglo1.length-1), j=0; i>=0;  i--, j++ ) {
			arreglo2[j] = arreglo1[i];
			System.out.println("El arreglo2 invertido es: [ "+ arreglo2[j]+" ]");
			
		}
		
		
	}//end 
	
	/**
	 * @Description Lista de enteros
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A 
	 * @return N/A
	 */
	public void listasDeEnteros() {
		
		List<Integer> listaNumeros = new ArrayList<>();
			listaNumeros.add(3);
			listaNumeros.add(5);
			listaNumeros.add(3);
			listaNumeros.add(70);
			listaNumeros.add(4);
			listaNumeros.add(70);
			listaNumeros.add(70);
			listaNumeros.add(4);
			listaNumeros.add(4);
		
		System.out.println("El valor de la lista es: " + listaNumeros);
		Collections.sort(listaNumeros);
		System.out.println("El valor de la lista ordenada de menor a mayor: " + listaNumeros);
		Collections.sort(listaNumeros, Collections.reverseOrder());
		System.out.println("El valor de la lista ordenada de mayor a menor: " + listaNumeros);
		System.out.println("El Numero mayor de la lista es : " + Collections.max(listaNumeros));
		System.out.println("El Numero menor de la lista es : " + Collections.min(listaNumeros));
		
		Object ultimo = null;
		int contador =0;
		Iterator<Integer> i = listaNumeros.iterator();
		
		
		while(i.hasNext()) {
			
			Object temporal = i.next();
			
			if(temporal.equals(ultimo)) {
				i.remove();
				contador++;
			}else {
				ultimo = temporal;
			}
			
		}//end while
		
		System.out.println("La cantidad de numeros repetidos fue: " +contador);
		System.out.println("La lsita sin elemenots repetidos es: "+ listaNumeros);
		
		
		
		
	}
	
	/**
	 * @Description Arreglo de String
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A 
	 * @return N/A
	 */
	public void arregloDeStrings() {
		String[] nombres = {"Sergio","Arturo","Rosa"};
		
		for(String nombre : nombres) {
			System.out.println("El nombre es:" + nombre);
		}
		
		String[] nombres2 = new String[5];
		
		for(int i= 0 ; i<nombres2.length; i++) {
			nombres2[i] = "Texto " + i;
			System.out.println("El nombre es:" + nombres2[i]);
		}

	}
	
	/**
	 * @Description Lista de String
	 * @author sramones
	 * @date 05/03/2022
	 * @param N/A 
	 * @return N/A
	 */
	public void listaDeStrings() {
		List<String> listaNombres = new ArrayList<>();
			
			
			
			for(int i = 1 ; i<=5; i++) {
				
				listaNombres.add("Persona " + i);
				
			}
			
			listaNombres.add("Persona 5");
			listaNombres.add("Persona 5");
			listaNombres.add("Persona 5");
			
			
			
			System.out.println(listaNombres);	
			
			Collections.sort(listaNombres, Collections.reverseOrder());
			System.out.println(listaNombres);
			
			
			
			System.out.println(listaNombres.stream().distinct().collect(Collectors.toList()));
			
			List<String> listaNombresSinRepetir = listaNombres.stream().distinct().collect(Collectors.toList());
			
			Collections.sort(listaNombresSinRepetir);
			System.out.println(listaNombresSinRepetir);
	}
	
}//end class
