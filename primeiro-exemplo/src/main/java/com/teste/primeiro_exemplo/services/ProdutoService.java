package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
          
    @Autowired
    private ProdutoRepository produtoRepository;


    /**
     * Metodo para Retorna uma lista com todos os produtos.
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        // coloca regra caso tenha aqui

        return produtoRepository.obterTodos();
    }


    /**
     * Metodo que retorna o produto encontrado pelo seu ID.
     * @param id ID do produto a ser buscado
     * @return  Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {

        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo que adiciona um novo produto na lista de produtos.
     * @param produto que sera adicionado
     * @return Retorna o produto adicionado com o ID atualizado.
     */
    public Produto adicionar(Produto produto) {
        //poderia ter alguma regra de negocio aqui
        return produtoRepository.adicionar(produto);
    }

    /**
     *  Metodo que deleta um produto da lista de produtos por ID.
     * @param id ID do produto a ser deletado
     */
    public void deletar(Integer id) {
        // poderia ter alguma logica de validação
        produtoRepository.deletar(id);
    }


    /**
     * Metodo que atualiza um produto existente na lista de produtos.
     * @param produto Produto com os dados atualizados
     * @return Retorna o produto atualizado.
     */
    public Produto atualizar(Integer id, Produto produto) {

        // Ter alguma validação no ID.
        produto.setId(id);
        
        return produtoRepository.atualizar(produto);
    }

}
