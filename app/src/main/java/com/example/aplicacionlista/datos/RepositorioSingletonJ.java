package com.example.aplicacionlista.datos;

public class RepositorioSingletonJ {

    private static final RepositorioSingletonJ instance = new RepositorioSingletonJ();

    private final RepositorioPersonajes repo;

    private RepositorioSingletonJ() {
        repo = new ListaPersonajes();
        repo.poblar();
    }
    public RepositorioPersonajes getRepo() {
        return repo;
    }

    public static RepositorioSingletonJ getInstance() {
        return instance;
    }
}
