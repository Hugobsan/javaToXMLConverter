# javaToXMLConverter
<p> Esse projeto foi uma proposta de atividade avaliativa da disciplina de Programação II do curso de Sistemas de Informação da Universidade Estadual de Montes Claros (UNIMONTES), disciplina ministrada pelo professor Allysson Costa e Silva.</p>
<p> O projeto tem como objetivo trabalhar o conceito de criação de um arquivo xml e sua estrutura. A proposta é criar um software que, dado um projeto java, percorra todos os subdiretórios do projeto e converta cada arquivo .java em um arquivo XML.</p>
<p> O arquivo XML respeitaria a estrutura do java, estabelecendo a seguinte hierarquia: </p>
 
 ```XML
 <classes>
    <classe>
       <nome>Nome da classe</nome>
       <atributos>
         <atributo>
           <tipo>Tipo do atributo</tipo>
           <nome>Nome do atributo</nome>
         </atributo>
       </atributos>
       <metodos>
         <metodo>
           <nome> Nome do Metodo </nome>
         </metodo>
       </metodos>
  </classe>
</classes>
 
 ```
