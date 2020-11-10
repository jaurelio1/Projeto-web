CREATE DATABASE alocarsalas;
USE alocarsalas;

CREATE TABLE sala (id INTEGER PRIMARY KEY);

#INSERT INTO sala (id) VALUES("dsd");

#SELECT * FROM disciplina;

CREATE TABLE professor (matricula INTEGER PRIMARY KEY,
						nome VARCHAR(100),
                        cargaHoraria INTEGER);
                        
CREATE TABLE disciplina (codigo INTEGER PRIMARY KEY,
						nome VARCHAR(100),
						quantidadeAlunos INTEGER,
                        cargaHoraria INTEGER,
                        diaAula VARCHAR(100),
                        inicioAula VARCHAR(100),
                        fimAula VARCHAR(100),
                        idSala INTEGER,
                        foreign key(idSala) references sala(id) on delete cascade);
                        
create table professor_disciplina(idProfessor integer,
								idDisciplina integer,
								foreign key (idProfessor) references professor(matricula) on delete cascade,
								foreign key (idDisciplina) references disciplina(codigo) on delete cascade) ;

