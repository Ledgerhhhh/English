<template>
  <div id="app">
    <router-view>
      <Main/>
    </router-view>
  </div>
</template>

<script>
import Main from '@/view/Main.vue'; // 引入子组件

export default {
  name: 'App',
  components: {
    Main
  }
}
</script>

<style>
body{
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  padding: 0;
  margin: 0;
}
*{
  padding: 0;
  left: 0;
}

::-webkit-scrollbar{
  display:none;
}
</style>
