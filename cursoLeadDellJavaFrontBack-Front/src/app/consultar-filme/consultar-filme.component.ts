import { Component, OnInit } from '@angular/core';
import { FilmeService } from './filme.service';
import { Filme } from './filme.model';

@Component({
  selector: 'app-cadastrar-filme',
  templateUrl: './cadastrar-filme.component.html',
  styleUrls: ['./cadastrar-filme.component.css']
})
export class CadastrarFilmeComponent implements OnInit {

  filmeService:FilmeService;

  constructor(filmeService:FilmeService) { 
    this.filmeService = filmeService;
  }

  ngOnInit(): void {
  }

  onSubmit(form) {
    let filme:Filme;

    filme = {
      id: null,
      nome: form.value.nome,
      genero: form.value.genero,
      ano: form.value.ano,
      autor: {
        id: null,
        nome: form.value.autorNome,
        dataNascimento: form.value.dataNascimento
      }
    }

    this.filmeService.cadastrarFilmes(filme).subscribe( dados => {
      console.log("Cadastrado com sucesso");
      console.log(dados);
    });
  }

}