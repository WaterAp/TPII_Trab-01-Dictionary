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
				
				System.out.println("    Inglês - Português ");
				for(int i = 0;i < all;i++) {
					int j = i+ 1;
					System.out.println(j+"-| "+word[i]+" - "+translatedWord[i]);
					
				}
				System.out.println();
				
				break;
			
				
			case 9:
				
				System.out.println("bye see you later - tchau até mais");
				control++;
				
				break;
			
			
			default:
				
				System.out.println("Opção inválida, tente de novo: ");
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
		System.out.println("|          Inglês   ------->   Português         |");
		System.out.println("|________________________________________________|");
		System.out.println("                                                  ");
		System.out.println("   1- Cadastrar uma nova palavra                  ");
		System.out.println("   2- Achar e consultar a tradução                ");
		System.out.println("   3- Editar                                      ");
		System.out.println("   4- Excluir                                     ");
		System.out.println("   5- Listar todas palavras                       ");
		System.out.println("                                                  ");
		System.out.println("   9- Sair                                        ");
		System.out.println("   Escolha uma opção.                             ");
		
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
			System.out.println("Não é mais possível adicionar palavras porque a memória está cheia!");
			
		} else {
			
			readMode = true;
			String auxWord, auxTranslation = "";
			do {
				System.out.println("Digite a palavra em inglês que deseja adicionar: ");
				auxWord = ler.nextLine();
				
			} while (ifHave(auxWord));
			
			System.out.println("Agora adicione a tradução para palavra -"+auxWord+"- :");
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
    		
    		System.out.println("Ainda não existem palavras adicionadas!");
    		
    	} else {
    		
        		System.out.println("Digite a palavra que deseja consultar a tradução:");
            	String auxWord = ler.nextLine();
            	
            	readMode = false;
            	if (ifHave(auxWord)) {
            	   
            		System.out.println("\n __________________________");
            		System.out.println("| Inglês  ---->  Português |"+" = "+word[ib]+ " ----> "+translatedWord[ib]+" \n");
            		
            		
            	} else {
            		
            		System.out.println("Essa palavra não esta presente na memoria do programa, tente outra!!!");
            		
            	}
        			
    	}
    		
    }
   
    public static void editing(String[] word, String[] translatedWord) {	
    	
    	if (ig == 0) { 		
           System.out.println("Ainda não existem palavras adicionadas!");
           
    	} else {
    		
    		int confirmation;
        	readMode = false;
            
        	System.out.println("DICA: caso não se lembre das palavras adicionadas utilize a opção [5] do menu.");
        	if (editMode) {
        		System.out.println("Digite a palavra em inglês que deseja buscar para editar:");
        		
        	} else {
        		System.out.println("Digite a palavra em inglês que deseja buscar para excluir:");
        		
        	}
        	
        	String auxWord = ler.nextLine();
        	String auxTranslation;
        	if (ifHave(auxWord)) {
        		if (editMode) {
        			System.out.println("Digite a nova forma da palavra -"+auxWord+"-, ou uma nova palavra: ");
        			auxWord = ler.nextLine();
        			
        			System.out.println("Agora digite a tradução para -"+auxWord+"- :");
        		    auxTranslation = ler.nextLine();
        			
        		storing(auxWord, auxTranslation);
        		
        		} else {
        			editMode = true;
        			boolean check = true;
        			
        			System.out.println("Você deseja excluir -"+auxWord+"- e sua tradução?");	
        			System.out.println("Digite:");
        			System.out.println("1- para confirmar");
        			System.out.println("2- para cancelar ação");
        			do {
        				confirmation = ler.nextInt();
        				if (confirmation == 2 || confirmation == 1) {
        						check = false;
        				} else {
        						System.out.println("Opção inválida, tente de novo: ");
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
        		System.out.println("Essa palavra não esta presente na memoria do programa, tente outra!!!");
        	}
    		
    	}
    	
    }
   
}