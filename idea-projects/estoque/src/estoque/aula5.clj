(ns estoque.aula5)

; exemplo de mapa (ou dicionario)
(def estoque {"Mochila" 10, "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "As chaves sao" (keys estoque))                    ; keys nao garante a ordem
(println "Os valores sao" (vals estoque))                   ; vals tbm nao garante a ordem

; maneira recomendavel para definir um mapa (com keywords)

(def estoque {:mochila 10, :camiseta 5})
(println estoque)

; incluir item ao mapa
(println (assoc estoque :cadeira 3))
(println estoque)
(println (assoc estoque :mochila 11))
(println estoque)

; outra forma de atualizar valores em mapas
(println "Usando update com mapas")
(println estoque)
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "Tirando 1 de" valor)
  (- valor 1))

(println estoque)
(println (update estoque :mochila tira-um))
(println estoque)
(println (update estoque :mochila #(- % 3)))                 ; chamando update mapa com lambda
(println estoque)

; retirar do mapa
(println "Usando dissoc em mapas")
(println estoque)
(println (dissoc estoque :mochila))