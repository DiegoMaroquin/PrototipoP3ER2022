

CREATE TABLE Tbl_perfil (
    per_idPerfil INT AUTO_INCREMENT PRIMARY KEY,
    per_NombrePerfil VARCHAR(30) NOT NULL,
    per_EstatusPerfil VARCHAR (30) NOT NULL
   
    )ENGINE=InnoDB CHARACTER SET = latin1;
    
 CREATE TABLE Tbl_aplicacionesPerfil(
      apl_idPerfil INT(11) ,
     apl_idaplicacion INT(11) ,
     
     PRIMARY KEY(apl_idPerfil),
     FOREIGN KEY (apl_idPerfil) REFERENCES Tbl_perfil (per_idPerfil),
     FOREIGN KEY (apl_idAplicacion) REFERENCES APLICACIONES (per_idAplicacion)
   
 )ENGINE=InnoDB CHARACTER SET = latin1;

