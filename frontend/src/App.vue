<template>
  <div id="content">
    <nav-bar></nav-bar>
    <slogan></slogan>
    <game></game>
  </div>
</template>

<script>
import NavBar from './navbar/NavBar.vue'
import Slogan from './slogan/Slogan.vue'
import Game from './game/Game.vue'
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    NavBar,
    Slogan,
    Game
  }
}
</script>

<style lang="scss">
  @import './assets/scss/style.scss';
</style>
