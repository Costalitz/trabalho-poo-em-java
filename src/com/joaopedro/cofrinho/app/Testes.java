// Não sei pq, mas o vscode não está mais reconhecendo o pacote abaixo, por isso, eu o deixarei comentado.
// package com.joaopedro.cofrinho.app;

import com.joaopedro.cofrinho.model.Dolar;
import com.joaopedro.cofrinho.model.Euro;
import com.joaopedro.cofrinho.model.Real;
import com.joaopedro.cofrinho.model.Cofrinho;

    // Classe com alguns testes pra ver se algumas partes funcionavam direitinho.

public class Testes {
    public static void main(String[] args) {

        // Testes individuais das moedas.
        Real r1 = new Real(10.0);
        r1.info();
        System.out.println("Dindin real -> R$" + r1.converter());

        Dolar d1 = new Dolar(30.0);
        d1.info();
        System.out.println("Doletas em reais -> R$" + d1.converter());
        
        Euro e1 = new Euro(75.0);
        e1.info();
        System.out.println("Eurozão em reais -> R$" + e1.converter());
    
        System.out.println("\n------------|-|-----------\n"); // Linha divisória pra melhor visualização.
        
        // Aqui é onde será mostrada apenas a lista de moedas | cálculo do total em reais.
        Cofrinho meuCofrinho = new Cofrinho();
        meuCofrinho.adicionar(new Real(150.0));
        meuCofrinho.adicionar(new Dolar(25.0));
        meuCofrinho.adicionar(new Euro(15.0));

        System.out.println("Moedas no cofrinho:");
        meuCofrinho.listarMoedas();

        System.out.printf("\n💰Total em reais: R$" + meuCofrinho.calcularTotal());

    }
}