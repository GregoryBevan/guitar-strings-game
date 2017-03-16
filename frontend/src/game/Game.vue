<template>
  <div class="container">
    <div class="row col-xs-12">
      <div class="col-xs-6 text-center">
        <h3>Corde</h3>
        <div>
          {{ string }}
        </div>
      </div>
      <div class="col-xs-6 text-center">
        <h3>Case</h3>
        <div class="">
          {{ fret}}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'game',
  data: ()=> ({
    string: 'E',
    fret: 0
  }),
  mounted() {
    this.getNewPosition()
  },
  methods: {
    getNewPosition: function() {
      this.$http.get('game/new-position').then((response) => {
        console.log(response);
      })
    }
  }
}
</script>
