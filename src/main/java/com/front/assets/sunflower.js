// let url = "localhost:8080/get-animals";
// let data = "";

// function init(){
//     fetch(url).then(r => r.json())
//   .then(data => {
//     createElement(data);
//   })
//   .catch(e => {
//     console.log("Deu ruim");
//   });
// }

function createElement(data) {
    let boxList = document.querySelector('.box-list-itens');
    

    let el = `{
        "regioes":[
            {
                "nome":"GO",
                "rank":[{
                   "vulgo":"macaquin",
                    "especie":"macacus macaquis",
                    "quantidade":"200"
                },{       
                   "vulgo":"foquinha",     
                    "especie":"focus foca",
                    "quantidade":"100"
                },{ 
                   "vulgo":"peixin",           
                    "especie":"lambari lambaris",
                    "quantidade":"50"
                }
                ]
            }, {
                "nome":"DF",
                "rank":[{
                   "vulgo":"macaquin",
                    "especie":"macacus macaquis",
                    "quantidade":"200"
                },{       
                   "vulgo":"foquinha",     
                    "especie":"focus foca",
                    "quantidade":"100"
                },{ 
                   "vulgo":"peixin",           
                    "especie":"lambari lambaris",
                    "quantidade":"50"
                }
                ]
            }, {
                "nome":"SP",
                "rank":[{
                   "vulgo":"macaquin",
                    "especie":"macacus macaquis",
                    "quantidade":"200"
                },{       
                   "vulgo":"foquinha",     
                    "especie":"focus foca",
                    "quantidade":"100"
                },{ 
                   "vulgo":"peixin",           
                    "especie":"lambari lambaris",
                    "quantidade":"50"
                }
                ]
            },
            {
                "nome":"SP",
                "rank":[
                {       
                    "vulgo":"piruleigo",     
                     "especie":"voadorus perus",
                     "quantidade":"100"
                 },{ 
                    "vulgo":"tortuguita",           
                     "especie":"marinhus tortuga",
                     "quantidade":"50"
                 }
                ]
            },
            {
                "nome":"sao-paulo",
                "rank":[
                {       
                    "vulgo":"piruleigo",     
                     "especie":"voadorus perus",
                     "quantidade":"100"
                 },{ 
                    "vulgo":"tortuguita",           
                     "especie":"marinhus tortuga",
                     "quantidade":"50"
                 }
                ]
            }
        ]
    }`;
    var data = JSON.parse(el);
    var regioes = data.regioes;
    var pos;
    for(pos in regioes){
        let region = regioes[pos]
        let regiao_el = document.createElement('ul');
        regiao_el.classList.add(`${region.nome}`);
        regiao_el.classList.add(`${region.nome}`+"-data");
        regiao_el.classList.add("hidden");

        let titulo = `
        <strong class="title column">Nome popular</strong>
        <strong class="title column">Nome científico</strong>
        <strong class="title column">Quantidade</strong>`;
      
      let titulo_item = document.createElement('li');
      titulo_item.classList.add('title_item');
      titulo_item.innerHTML = titulo;
      regiao_el.appendChild(titulo_item);



        var inner_pos;
        var rank = region.rank;
        for(inner_pos in rank){
            var ranking = rank[inner_pos];
            let item_list = document.createElement('li');
            item_list.classList.add('item')
            let result = `
            <p class="column">
              <span class="vulgo">${ranking.vulgo}</span>
            </p>
            <p class="column">
              <span class="especie">${ranking.especie}</span>
            </p>
            <p class="column">
              <span class="quantidade">${ranking.quantidade}</span>
            </p>
            `;

            item_list.innerHTML = result;
            regiao_el.appendChild(item_list);
        }

        boxList.appendChild(regiao_el);
    }
 

  }
  
 

  function read(data) {
    let el = `{
        "regioes":[
            {
                "nome":"norte",
                "rank":[{
                   "vulgo":"macaquin",
                    "especie":"macacus macaquis",
                    "quantidade":"200"
                },{       
                   "vulgo":"foquinha",     
                    "especie":"focus foca",
                    "quantidade":"100"
                },{ 
                   "vulgo":"peixin",           
                    "especie":"lambari lambaris",
                    "quantidade":"50"
                }
                ]
            },
            {
                "nome":"sul",
                "rank":[
                {       
                    "vulgo":"piruleigo",     
                     "especie":"voadorus perus",
                     "quantidade":"100"
                 },{ 
                    "vulgo":"tortuguita",           
                     "especie":"marinhus tortuga",
                     "quantidade":"50"
                 }
                ]
            }
        ]
    }`;
    
    
    var obj = JSON.parse(el);
    }

    window.addEventListener('load', function() {
        
        createElement();
      })

function toggle(regiaoClass){
    var regioes = document.getElementsByClassName(regiaoClass);

    var pos;

    for(pos in regioes){
        var regiao = regioes[pos];

      if (regiao.classList.contains('hidden')) {
        regiao.classList.remove('hidden');
      } else {
        regiao.classList.add('hidden');
      }
    }

}     