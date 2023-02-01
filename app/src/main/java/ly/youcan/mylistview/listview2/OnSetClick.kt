package ly.youcan.mylistview.listview2

interface OnSetClick {
    fun onItemClick(name: Names)
    fun addItem(context: CoustemAdapter, position: Int, name: Names)
    fun removeItem(context: CoustemAdapter,position: Int)
}