/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplo.bd;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Lucas
 */
public class TesteBanco {

    public static void main(String[] args) {

        Conection config = new Conection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        // Uso simples do JDBC (sem associação com classe)
        //System.out.println(con.queryForList("select * from Pokemon;")); 
        List pokemonUsoSimples = con.queryForList("select * from Blacklist;");
        System.out.println(pokemonUsoSimples);
    }
//
//        // Uso avançado do JDBC - inclui uso de classe para mapear a tabela
//        // por isso fizemos a classe Pokemon, cujos atributos devem corresponder
//        // às colunas da tabela Pokemon
//        List<Pokemon> pokemonUsoAvançado = con.query("select * from Pokemon;",
//                new BeanPropertyRowMapper(Pokemon.class));
//
//        for (Pokemon p : pokemonUsoAvançado) {
//            System.out.println(p);
//        }
//
//        String insertStatement = "insert into Pokemon values (null,?,?);";
//
//        con.update(insertStatement, "magikarp", "agua");
//        con.update(insertStatement, "gyrados", "agua");
//        pokemonUsoAvançado = con.query("select * from Pokemon;",
//                new BeanPropertyRowMapper(Pokemon.class));
//        System.out.println("");
//        for (Pokemon p : pokemonUsoAvançado) {
//            System.out.println(p);
//        }
//
//        List<Pokemon> pokemonTipoFogo = con.query("select * from Pokemon where tipo = 'fogo';",
//                new BeanPropertyRowMapper(Pokemon.class));
//
//        for (Pokemon p : pokemonUsoAvançado) {
//            System.out.println(p);
//        }
//        
//       con.update("delete from pokemon where id between 6 and 10;");
//       pokemonUsoAvançado = con.query("select * from pokemon;",
//               new BeanPropertyRowMapper(Pokemon.class));
//       
//       for (Pokemon p : pokemonUsoAvançado){
//           System.out.println(p);
//       }
//            System.out.println("Deletando acima do 5");
//        con.update("delete from pokemon where id > 5;");
//       pokemonUsoAvançado = con.query("select * from pokemon;",
//               new BeanPropertyRowMapper(Pokemon.class));
//       
//       for (Pokemon p : pokemonUsoAvançado){
//           System.out.println(p);
//       }
    //}
}
