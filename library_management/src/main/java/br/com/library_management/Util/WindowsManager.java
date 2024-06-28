package br.com.library_management.Util;

import javafx.stage.Stage;

/* Configuração padrão para todas as Janelas em meu Projeto.*/
public class WindowsManager {
    
    /*são variáveis estáticas. Isso significa que elas mantêm seu valor entre todas as instâncias da 
    classe WindowManager e, por extensão, entre todas as janelas que utilizam essa classe. */
    private static double width = 1200;
    private static double height = 750;
    private static boolean maximized = false; /*False = Não Maximizada && True = Maximizado */


    public void applyStandardSize(Stage stage) {
        
        //Stage(Janela) setado os valores estático
        stage.setWidth(width);
        stage.setHeight(height);
        //Se for TRUE maximiza a tela, falso mantém as dimensões especificadas acima.
        stage.setMaximized(maximized);

        // Listener para acompanhar mudanças no tamanho e estado da janela
        /*Um listener é um mecanismo que permite que você reaja a mudanças em uma propriedade. Ele "ouve"
         mudanças na propriedade e executa uma ação quando essa mudança ocorre.*/
        stage.widthProperty().addListener((obs, oldVal, newVal) -> width = newVal.doubleValue());
        stage.heightProperty().addListener((obs, oldVal, newVal) -> height = newVal.doubleValue());
        stage.maximizedProperty().addListener((obs, oldVal, newVal) -> maximized = newVal);


    }
}


/*Conclusão:
stage.widthProperty(): Obtém a propriedade observável da largura da janela.
addListener: Adiciona um listener a essa propriedade.
(obs, oldVal, newVal): É a expressão lambda que define o listener.
obs: O objeto observável que está sendo escutado.
oldVal: O valor antigo da propriedade antes da mudança.
newVal: O novo valor da propriedade após a mudança.


listeners acompanham mudanças nas propriedades da janela e atualizam 
as variáveis estáticas correspondentes. Isso garante que qualquer alteração feita na largura, altura ou
estado maximizado de uma janela seja refletida em todas as futuras janelas abertas. A função lambda usada 
nos listeners simplifica a definição de ações a serem executadas quando ocorrem mudanças nas propriedades.
*/