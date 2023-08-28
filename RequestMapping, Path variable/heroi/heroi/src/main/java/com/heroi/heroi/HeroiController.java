package com.heroi.heroi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")

public class HeroiController {

    //Criando a Lista
    private List<Heroi> listaHeroi = new ArrayList<>();

    // 1 - Exibe Lista
    //http://localhost:8080/herois
    @GetMapping()
    public String herois() {
        return String.format(listaHeroi.toString());
    }

    // Boolean Indice Invalido
    private boolean indiceInvalido(Integer indice) {
        return indice < 0 || indice >= this.listaHeroi.size();
    }

    // 2 - Procurar Herói pelo Indice
    //http://localhost:8080/herois/0
    @GetMapping("/{indice}")
    public String heroisIndice(@PathVariable Integer indice) {
        if (this.indiceInvalido(indice)) {
            return null;
        } else {
            return listaHeroi.get(indice).toString();
        }
    }

    // 3 - Cadastrar Herói
    //http://localhost:8080/herois/cadastrar/Mariana/Invisibilidade/10/20/false
    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public String heroisCadastrar(@PathVariable String nome, @PathVariable String habilidade, @PathVariable Integer idade, @PathVariable Integer forca, @PathVariable boolean vivo) {
        Heroi heroi = new Heroi(nome, habilidade, idade, forca, vivo);
        listaHeroi.add(heroi);
        return String.format("O Héroi %s foi cadastrado! 🦸‍♀️", nome);
    }

    // 4 - Atualizar Herói
    //http://localhost:8080/herois/atualizar/0/rub/Invisibilidade/10/20/false
    @GetMapping({"/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}"})
    public String atualizar(@PathVariable int indice, @PathVariable String nome, @PathVariable String habilidade, @PathVariable Integer idade, @PathVariable Integer forca, @PathVariable boolean vivo) {
        if (indiceInvalido(indice)) {
            return "Herói não encontrado!";
        } else {
            Heroi heroiAtual = listaHeroi.get(indice);
            heroiAtual.setNome(nome);
            heroiAtual.setHabilidade(habilidade);
            heroiAtual.setIdade(idade);
            heroiAtual.setForca(forca);
            heroiAtual.setVivo(vivo);

            return "Herói atualizado!";
        }
    }

    // 5 - Remover Herói
    //http://localhost:8080/herois/remover/0
    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable Integer indice) {

        if (this.indiceInvalido(indice)) {
            return "Herói não encontrado";
        } else {
            listaHeroi.remove(indice);
            return "Herói removido";
        }

    }

}

