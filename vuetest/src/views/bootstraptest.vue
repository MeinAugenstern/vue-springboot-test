<template>
  <div>
    <a class="btn btn-default" href="#" role="button">Link</a>
    <button class="btn btn-secondary" type="submit">Button</button>
    <input class="btn btn-default " type="button" value="Input">
    <input class="btn btn-default" type="submit" value="Submit">

  </div>
</template>

<script>
  import 'bootstrap/dist/js/bootstrap.min.js'
  import 'bootstrap/dist/css/bootstrap.min.css'
  export default {
    name: 'bootstraptest',
    data(){
      return {
        books:[
          {id:1,name:"红楼梦",price:32},
          {id:2,name:"水浒传",price:48},
          {id:3,name:"三国演义",price:24},
          {id:4,name:"西游记",price:15},
        ]
      }
    }
  }
</script>

<style scoped>

</style>
