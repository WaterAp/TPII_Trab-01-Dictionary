package br.edu.univas;

import java.util.Scanner;

public class StartApp {
    
	static boolean readMode = true, editMode = true;
	static int all = 101, ig = 0, ib = 0;
	static Scanner ler = new Scanner(System.in);
	static String[] word = new String[all];
	static String[] translatedWord = new String[all];
	
	public static void main(String[] args) {
		
		for (int i = 0;i < all;i++) {
			
			word[i] = " ";
			translatedWord[i] = " ";
		}
		
		int opcao;
		int control = 0;
		do {
			
			menu();
			opcao = ler.nextInt();
			ler.nextLine();
			
			System.out.println();
			switch (opcao) {
			     
			case 1: 
				
				editMode = false;
				read(word, translatedWord);
				System.out.println();
				break;
				
			case 2:
				
				showWord(word, translatedWord);
				System.out.println();
				break;
				
				
			case 3: 
				
				editMode = true;
				editing(word, translatedWord);
				System.out.println();
				break;
				
			case 4:
				
				editMode = false;
				editing(word, translatedWord);
				System.out.println();
				break;
				
			case 5:
				
				System.out.println("    Ingl�s - Portugu�s ");
				for(int i = 0;i < all;i++) {
					int j = i+ 1;
					System.out.println(j+"-| "+word[i]+" - "+translatedWord[i]);
					
				}
				System.out.println();
				
				break;
			
				
			case 9:
				
				System.out.println("bye see you later - tchau at� mais");
				control++;
				
				break;
			
			
			default:
				
				System.out.println("Op��o inv�lida, tente de novo: ");
				System.out.println();
				break;
			
			}
					
		} while (control < 1);
		
       ler.close();
	}

	public static void menu() {
		
		System.out.println(" ________________________________________________ ");
		System.out.println("|                   Dicionario                   |");
		System.out.println("|------------------------------------------------|");
		System.out.println("|          Ingl�s   ------->   Portugu�s         |");
		System.out.println("|________________________________________________|");
		System.out.println("                                                  ");
		System.out.println("   1- Cadastrar uma nova palavra                  ");
		System.out.println("   2- Achar e consultar a tradu��o                ");
		System.out.println("   3- Editar                                      ");
		System.out.println("   4- Excluir                                     ");
		System.out.println("   5- Listar todas palavras                       ");
		System.out.println("                                                  ");
		System.out.println("   9- Sair                                        ");
		System.out.println("   Escolha uma op��o.                             ");
		
	}

	public static boolean ifHave(String auxWord) {
		
		if (ig == 0) {
			
			return false;
			
		} else {
			
			for (int j = 0; j < all;j++) {
				
				if (auxWord.equalsIgnoreCase(word[j])) {
					if (readMode) {
						System.out.println("Esta palavra ja esta adicionada, tente de novo \n");
					}
					ib = j;
					return true;
				}
			
				if (readMode) {
					if (auxWord.equalsIgnoreCase(translatedWord[j])) {
						System.out.println("Esta palavra ja esta adicionada, tente de novo \n");
						
						ib = j;
						return true;
					}
					
				}
				
		   }
		
	    }
		
		return false;
    }
	
	public static void read(String[] word, String[] translatedWord) {
		if (ig == all-1) {
			System.out.println("N�o � mais poss�vel adicionar palavras porque a mem�ria est� cheia!");
			
		} else {
			
			readMode = true;
			String auxWord, auxTranslation = "";
			do {
				System.out.println("Digite a palavra em ingl�s que deseja adicionar: ");
				auxWord = ler.nextLine();
				
			} while (ifHave(auxWord));
			
			System.out.println("Agora adicione a tradu��o para palavra -"+auxWord+"- :");
			auxTranslation = ler.nextLine();
			
			storing(auxWord, auxTranslation);
						
		}

	}	
    
    public static void storing (String auxWord, String auxTranslation) {
    	
    	if (editMode) {
    		word[ib] = auxWord;
			translatedWord[ib] = auxTranslation;  

    	} else { 
    		
    		for (int i = 0;i < all;i++) {
        		
        		if (ig == 0) {
        			
        			word[i] = auxWord;
        			translatedWord[i] = auxTranslation; 
        			break;
        			
        		} else if (word[i].isBlank()) {
        			
        			word[i] = auxWord;
        			translatedWord[i] = auxTranslation;
        			break;
        		}
        		
        	}	
        	System.out.println("A palavra '"+auxWord+"' foi registrada com sucesso!");
        	ig++;		
    	}
    	
    }
    
    public static void showWord(String[] word, String[] translatedWord) {
    	
    	if (ig == 0) {
    		
    		System.out.println("Ainda n�o existem palavras adicionadas!");
    		
    	} else {
    		
        		System.out.println("Digite a palavra que deseja consultar a tradu��o:");
            	String auxWord = ler.nextLine();
            	
            	readMode = false;
            	if (ifHave(auxWord)) {
            	   
            		System.out.println("\n __________________________");
            		System.out.println("| Ingl�s  ---->  Portugu�s |"+" = "+word[ib]+ " ----> "+translatedWord[ib]+" \n");
            		
            		
            	} else {
            		
            		System.out.println("Essa palavra n�o esta presente na memoria do programa, tente outra!!!");
            		
            	}
        			
    	}
    		
    }
   
    public static void editing(String[] word, String[] translatedWord) {	
    	
    	if (ig == 0) { 		
           System.out.println("Ainda n�o existem palavras adicionadas!");
           
    	} else {
    		
    		int confirmation;
        	readMode = false;
            
        	System.out.println("DICA: caso n�o se lembre das palavras adicionadas utilize a op��o [5] do menu.");
        	if (editMode) {
        		System.out.println("Digite a palavra em ingl�s que deseja buscar para editar:");
        		
        	} else {
        		System.out.println("Digite a palavra em ingl�s que deseja buscar para excluir:");
        		
        	}
        	
        	String auxWord = ler.nextLine();
        	String auxTranslation;
        	if (ifHave(auxWord)) {
        		if (editMode) {
        			System.out.println("Digite a nova forma da palavra -"+auxWord+"-, ou uma nova palavra: ");
        			auxWord = ler.nextLine();
        			
        			System.out.println("Agora digite a tradu��o para -"+auxWord+"- :");
        		    auxTranslation = ler.nextLine();
        			
        		storing(auxWord, auxTranslation);
        		
        		} else {
        			editMode = true;
        			boolean check = true;
        			
        			System.out.println("Voc� deseja excluir -"+auxWord+"- e sua tradu��o?");	
        			System.out.println("Digite:");
        			System.out.println("1- para confirmar");
        			System.out.println("2- para cancelar a��o");
        			do {
        				confirmation = ler.nextInt();
        				if (confirmation == 2 || confirmation == 1) {
        						check = false;
        				} else {
        						System.out.println("Op��o inv�lida, tente de novo: ");
        				  }
        					
        				} while (check);
        			
        					if(confirmation == 1) {	
        						auxWord = " ";
        						auxTranslation = " ";
        						storing(auxWord, auxTranslation);
        						System.out.println("palavra excluida!");
        				}	
        			 }
        		
        	} else {
        		System.out.println("Essa palavra n�o esta presente na memoria do programa, tente outra!!!");
        	}
    		
    	}
    	
    }
   
}