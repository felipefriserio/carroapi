package br.com.feliperiserio.carroapi.controller

import br.com.feliperiserio.carroapi.entity.Carro
import br.com.feliperiserio.carroapi.service.CarroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carro")
class CarroController{

    @Autowired
    lateinit var carroService : CarroService

    @GetMapping
    fun buscarTodos() : List<Carro>{
        return carroService.buscarTodosOsCarros()
    }
    
    @PutMapping
    fun atualizar(@RequestBody carro: Carro){
       carroService.salvar(carro)
    }
    
    @GetMapping("/find/{placa}")
    fun buscarPorPlaca(@PathVariable("placa") placa : String ) : Carro{
        return carroService.buscarCarroPorPlaca(placa)
    }

    @PostMapping
    fun salvar(@RequestBody carro: Carro){
        carroService.salvar(carro)
    }
}
