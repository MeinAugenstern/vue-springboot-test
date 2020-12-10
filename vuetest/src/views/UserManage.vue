<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 70%">
      <el-table-column
        fixed
        prop="id"
        label="编号"
        width="200">
      </el-table-column>
      <el-table-column
        prop="account"
        label="账号"
        width="200">
      </el-table-column>
      <el-table-column
        prop="password"
        label="密码"
        width="200">
      </el-table-column>
      <el-table-column
        prop="realname"
        label="真实姓名"
        width="200">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="105">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pageSize"
      :total="total"
      @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    methods: {
      deleteBook(row){
        const _this = this
        axios.delete('http://localhost:8181/deleteById/'+row.id).then(function(resp){
          _this.$alert(row.account+'删除成功！', '消息', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()
            }
          })
        })
      },
      edit(row) {
        this.$router.push({
          path: '/UpdateUser',
          query:{
            id:row.id
          }
        })
      },
      page(currentPage){
        const _this = this
        axios.get('http://localhost:8181/page/'+currentPage+'/3').then(function(resp){
          console.log(resp)
          _this.tableData = resp.data.list
          _this.pageSize = resp.data.pageSize
          _this.total = resp.data.total
        })
      }
    },

    data() {
      return {
        pageSize:'1',
        total:'11',
        tableData: [{
          id: 1,
          account: 'admin',
          password: 'admin',
          realname:'cn'
        }, {
          id: 2,
          account: 'zjut',
          password: 'zjut',
          realname:'zjut'
        }, {
          id: 3,
          account: 'test',
          password: 'test',
          realname:'test'
        }]
      }
    },

    created() {
      const _this = this
      axios.get('http://localhost:8181/page/1/3').then(function(resp){
        console.log(resp)
        _this.tableData = resp.data.list
        _this.pageSize = resp.data.pageSize
        _this.total = resp.data.total
      })
    }
  }
</script>
