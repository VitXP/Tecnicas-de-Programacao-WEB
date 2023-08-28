package com.sptech.estoque01222064vitorxavierpereira.Controller;


import com.sptech.estoque01222064vitorxavierpereira.Entidade.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    // Lista
    private List<Produto> produtos = new ArrayList<>();

    // http://localhost:8080/produtos --> Cadastrar
    @PostMapping
    public Produto cadastrar(@RequestBody Produto novoProduto){
        this.produtos.add(novoProduto);
        return novoProduto;
    }

    // http://localhost:8080/produtos --> Exibir
    @GetMapping
    public List<Produto> exibir(){
        return  this.produtos;
    }

    //Boolean indice
    public boolean isIndiceValido(int indice) {
        return indice >= 0 && indice < this.produtos.size();
    }

    // http://localhost:8080/produtos/0 --> Atualizar
    @PutMapping("/{indice}")
    public Produto atualizar(@PathVariable int indice, @RequestBody Produto produtoAtualizado){

        if(isIndiceValido(indice)){
            this.produtos.set(indice,produtoAtualizado);
            return produtos.get(indice);
        } else {
            return null;
        }
    }

    //http://localhost:8080/produtos/estoque/{qtdEstoque} --> Exibir maior que qtdEstoque
    @GetMapping ("/estoque/{indice}")
    public List<Produto> exibirMaiorQue(@PathVariable int indice){

         List<Produto> estoque = new ArrayList<>();

        for(Produto produto: produtos){
            if(produto.getQtdEstoque() > indice){
                estoque.add(produto);
            }
        }
        return estoque;
    }
}
