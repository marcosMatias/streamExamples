/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author marcos
 */
public class StreamExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa(1L, "Pedro", 40));
        pessoas.add(new Pessoa(2L, "Maria", 38));
        pessoas.add(new Pessoa(3L, "João", 29));
        pessoas.add(new Pessoa(4L, "tião", 72));

        pessoas.stream().forEach(e -> System.out.println(e.getNome()));

        long b = pessoas.stream()
                .filter(c -> c.getId() >= 3)
                .count();

        System.out.println("Total de id's maior ou igual a 3 " + b);

        List<Pessoa> pessoasFilterList = pessoas.stream()
                .filter(f -> f.getId() >= 3)
                .collect(Collectors.toList());

        pessoasFilterList.forEach(f -> System.out.println(f.getNome()));

        // transformando em uma lista de ID's long      
        List<Long> lista = pessoas.stream()
                .map(c -> c.getId())
                .filter(f -> f > 2)
                .collect(Collectors.toList());
        lista.forEach(l -> System.out.println(l));

        // usando reduce para acumular a idade, somar todas as idades.
        Optional<Integer> reduce = pessoas.stream()
                .map(c -> c.getIdade())
                .reduce((n1, n2) -> n1 + n2);

        System.out.println("Total das idades: " + reduce.get());

        System.out.println("\n*****************************************************************\n");

        List<String> pessoasString = List.of("João", "Maria", "Pedro");

        System.out.println("Exibe a lista toda de pessoasString");

        pessoasString.stream()
                .forEach(System.out::println);

        // conta os elementos da lista  
        System.out.println(pessoasString.stream().count());

        // recuprea qualquer elemento da lista, se encontrado o valor exibe na saida do log
        Optional<String> opt = pessoasString.stream().findAny();
        opt.ifPresent(System.out::println);

    }

}
