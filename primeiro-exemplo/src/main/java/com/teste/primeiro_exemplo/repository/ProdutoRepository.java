package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;


@Repository
public class ProdutoRepository {
    
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Metodo para Retorna uma lista com todos os produtos cadastrados.
     * @return Lista de  produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }


    /**
     * Metodo que retorna o produto encontrado pelo seu ID.
     * @param id ID do produto a ser buscado
     * @return  Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
            .stream()
            .filter(produto -> produto.getId() == id)
            .findFirst();
    }

    /**
     * Metodo que adiciona um novo produto na lista de produtos.
     * @param produto que sera adicionado
     * @return Retorna o produto adicionado com o ID atualizado.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     *  Metodo que deleta um produto da lista de produtos por ID.
     * @param id ID do produto a ser deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }



    /**
     * Metodo que atualiza um produto existente na lista de produtos.
     * @param produto Produto com os dados atualizados
     * @return Retorna o produto atualizado.
     */
    public Produto atualizar(Produto produto) {

        // Encontra o produto antigo
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("Produto não encontrado");
        }

        // Tenho que remover o produto antigo
        deletar(produto.getId());
        
        // Depois adicionar o novo produto
        produtos.add(produto);
        return produto;
    
    }

}
