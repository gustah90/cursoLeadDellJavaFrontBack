package br.com.lead.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;
import br.com.lead.util.JPAUtil;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "Ação", 1999);
		Filme forrestGump = new Filme("Forrest Gump", "Drama", 1994);*/
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Filme  filme = em.find(Filme.class, 1);
		
		em.close();
		
		ArrayList<Filme> listaFiltrada = new ArrayList<Filme>();
		listaFiltrada.add(filme);
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lista-filmes.jsp");
		dispatcher.forward(req, resp);
		
		/*filmes.add(coringa);
		filmes.add(matrix);
		filmes.add(forrestGump);
		
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		//String ano = req.getParameter("ano");*/
		
		
		/*ArrayList<Filme> listaFiltrada = filmes.stream().filter(filme -> filme.getGenero().toUpperCase().equals(genero.toUpperCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lista-filmes.jsp");
		dispatcher.forward(req, resp);
		
		
		ArrayList<Filme> infoFilme = filmes.stream().filter(filme -> filme.getNome().toUpperCase().equals(nome.toUpperCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		req.setAttribute("infoFilme", infoFilme);
		
		RequestDispatcher dispatcher2 = req.getRequestDispatcher("/infofilme.jsp");
		dispatcher2.forward(req, resp);*/

		
	}

}
