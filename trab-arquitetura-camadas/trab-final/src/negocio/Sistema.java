package negocio;

import negocio.estoque.Estoque;
import negocio.estoque.EstoqueDAO;
import negocio.fornecedor.Fornecedor;
import negocio.fornecedor.FornecedorDAO;
import negocio.produto.Produto;
import negocio.produto.ProdutoDAO;

public class Sistema implements IFachadaSistema {
    FornecedorDAO daoF = new FornecedorDAO();
    ProdutoDAO daoP = new ProdutoDAO();
    EstoqueDAO daoE = new EstoqueDAO();

    private static IFachadaSistema fac;

    private Sistema() throws Exception {
        daoF.recuperar();
    }

    static public IFachadaSistema getFachada() throws Exception {
        if (fac == null)
            fac = new Sistema();

        return fac;
    }

    public void cadastrar(Fornecedor f) throws Exception {
        try {
            daoF.busca(f.getCpf());
        } catch (Exception e) {
            f.setId(daoF.getNextId());
            daoF.incluir(f);
            daoF.salvar();
            return;
        }
        throw new Exception("Fornecedor ja cadastrado!");
    }

    public Fornecedor buscar(String cpf) throws Exception {
        return daoF.busca(cpf);
    }

    public void excluir(String cpf) throws Exception {
        daoF.remover(cpf);
        daoF.salvar();
    }

    public void atualizar(Fornecedor f) throws Exception {
        daoF.atualizar(f);
        daoF.salvar();
    }

    public void cadastrarProduto(Produto p) throws Exception {
        try {
            daoP.busca(p.getCodigo());
        } catch (Exception e) {
            p.setId(daoP.getNextId());
            daoP.incluir(p);
            daoP.salvar();
            return;
        }
        throw new Exception("Produto ja cadastrado!");
    }

    public Produto buscarProduto(String codigo) throws Exception {
        return daoP.busca(codigo);
    }

    public void excluirProduto(String codigo) throws Exception {
        daoP.remover(codigo);
        daoP.salvar();
    }

    public void atualizarProduto(Produto p) throws Exception {
        daoP.atualizar(p);
        daoP.salvar();
    }

    public void cadastrarEstoque(Estoque est) throws Exception {
        try {
            daoE.busca(est.getNomeFornecedor());
        } catch (Exception e) {
            est.setId(daoE.getNextId());
            daoE.incluir(est);
            daoE.salvar();
            return;
        }
        throw new Exception("Estoque ja cadastrado!");
    }

    public Estoque buscarEstoque(String fornecedor) throws Exception {
        return daoE.busca(fornecedor);
    }

    public void excluirEstoque(String fornecedor) throws Exception {
        daoE.remover(fornecedor);
        daoE.salvar();
    }

    public void atualizarEstoque(Estoque e) throws Exception {
        daoE.atualizar(e);
        daoE.salvar();
    }

}
