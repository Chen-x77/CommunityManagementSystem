//添加成功
function addInfo() {
    Swal.fire({
        position: 'top',
        icon: 'success',
        title: '提交成功',
        showConfirmButton: false,
        timer: 1500
    })
}


//修改成功
function revise() {
    Swal.fire({
        position: 'top',
        icon: 'success',
        title: '修改成功',
        showConfirmButton: false,
        timer: 1500
    })
}

//删除
function shanchu() {
    Swal.fire({
        position: 'top-center',
        icon: 'warning',
        title: '确定删除吗？',
        showConfirmButton: true,
        showCancelButton: true,
        confirmButtonColor: '#d33'
    }).then((result) => {
        if (result.value) {

            Swal.fire({
                title: '删除!',
                text: '该项数据已被删除',
                icon: 'success',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}
