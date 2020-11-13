CREATE DATABASE alocarsalas;
USE alocarsalas;

CREATE TABLE sala (id INTEGER PRIMARY KEY,
					nome VARCHAR(100));

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
                        inicioAula INTEGER,
                        fimAula INTEGER,
                        idSala INTEGER,
                        FOREIGN KEY(idSala) REFERENCES sala(id) ON DELETE CASCADE);
                        
CREATE TABLE professor_disciplina(idProfessor INTEGER,
								idDisciplina INTEGER,
								FOREIGN KEY (idProfessor) REFERENCES professor(matricula) ON DELETE CASCADE,
								FOREIGN KEY (idDisciplina) REFERENCES disciplina(codigo) ON DELETE CASCADE) ;

