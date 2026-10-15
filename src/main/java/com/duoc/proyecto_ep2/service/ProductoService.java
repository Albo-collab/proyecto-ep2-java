package com.duoc.proyecto_ep2.service;

import com.duoc.proyecto_ep2.exception.RecursoNoEncontradoException;
import com.duoc.proyecto_ep2.model.Categoria;
import com.duoc.proyecto_ep2.model.Producto;
import com.duoc.proyecto_ep2.repository.CategoriaRepository;
import com.duoc.proyecto_ep2.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        producto.setId(null);
        producto.setCategoria(resolverCategoria(producto.getCategoria()));
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto con id " + id + " no existe"));
        existente.setNombre(productoActualizado.getNombre());
        existente.setPrecio(productoActualizado.getPrecio());
        existente.setDescripcion(productoActualizado.getDescripcion());
        existente.setCategoria(resolverCategoria(productoActualizado.getCategoria()));
        return productoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto con id " + id + " no existe"));
        productoRepository.delete(existente);
    }

    // Comprueba que la categoria exista en la base de datos
    private Categoria resolverCategoria(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            return null;
        }
        return categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Categoria con id " + categoria.getId() + " no existe"));
    }
}
