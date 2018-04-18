package br.com.feliperiserio.carroapi.service

import br.com.feliperiserio.carroapi.entity.Carro
import br.com.feliperiserio.carroapi.repository.CarroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarroService{
    @Autowired
    lateinit var carroRepository : CarroRepository

    fun buscarTodosOsCarros() : List<Carro>{
        return carroRepository.findAll()
    }

    fun buscarCarroPorAno(ano: Int): List<Carro>{
        return carroRepository.findByAno(ano)
    }

    fun buscarCarroPorMarca(marca: String): List<Carro>{
        return carroRepository.findByMarcaContaining(marca)
    }

    fun buscarCarroPorPlaca(placa: String) : Carro {
        return carroRepository.findByPlaca(placa)
    }

    fun salvar(carro: Carro){
        carroRepository.save(carro)
    }
}