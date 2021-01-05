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
(println (update estoque :mochila #(- % 3)))                ; chamando update mapa com lambda
(println estoque)

; retirar do mapa
(println "Usando dissoc em mapas")
(println estoque)
(println (dissoc estoque :mochila))

;;;
; mapas aninhados
;;;

(println "\n\n\n")

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)
(println (pedido :mochila))                                 ; usando mapa como funcao, se pedido for null, vai lancar NullPointerException
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira {}))                          ; get com valor default {}
(println (:mochila pedido))
(println (:cadeira pedido {}))

; modo prefix de chamadas de funcao
(println (:quantidade (:mochila pedido)))

(println pedido)
(println (update-in pedido [:mochila :quantidade] inc))

; THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))

; ou...
(-> pedido :mochila :quantidade println)

;;;
; exercicios
;;;

(def clientes {
               :15 {
                    :nome "Ivo"
                    :certificados ["Clojure" "Java" "Machine Learning"]
                    }
               })

(-> clientes :15 :certificados count)



