<template>

    <v-card outlined>
        <v-card-title>
            ResevationHist # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ScheduleId" v-model="item.scheduleId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Mileage" v-model="item.mileage" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="EventType" v-model="item.eventType" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ResevationHistViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/resevationHists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

