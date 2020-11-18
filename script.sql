#CREATE DATABASE alocarsalas;
#USE alocarsalas;

#INSERT INTO sala (id) VALUES("dsd");

SELECT * FROM sala;

USE heroku_fa606a17340eaa3;

CREATE TABLE sala (codigo INTEGER PRIMARY KEY,
					nome VARCHAR(100));

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
                        FOREIGN KEY(idSala) REFERENCES sala(codigo) ON DELETE CASCADE);
                        
CREATE TABLE professor_disciplina(idProfessor INTEGER,
								idDisciplina INTEGER,
								FOREIGN KEY (idProfessor) REFERENCES professor(matricula) ON DELETE CASCADE,
								FOREIGN KEY (idDisciplina) REFERENCES disciplina(codigo) ON DELETE CASCADE) ;

