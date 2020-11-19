# coding:utf-8


'''
    1.1 Array basics
'''

def doubleArrayConstructor(dim1,dim2):
    '''
    The method of creating a new blank double dimentional array
    :param dim1: the first dimention
    :param dim2: the second dimention
    :return: a double dimentions array
    '''
    array=[[0 for _ in range(dim1)] for _ in range(dim2)]
    return array

def arrayOperation():
    '''
    The basic operations of a liner array
    '''
    # append() will add an element at the end of the array
    linearArray = [1, 0, 2, 4, 2, 0, 4, 8]
    print("Original array", linearArray)
    print("=======================================")
    linearArray.append(1)
    print("Append operation:")
    print("The array became:",linearArray)
    print("=======================================")

    #remove() will remove the first matched element
    print("Remove operation:")
    linearArray.remove(8)
    print("The array became:", linearArray)
    print("=======================================")

    #pop will remove the first element by default
    #or remove the element of the index
    print("Pop operation:")
    print("The removed element by default is:",linearArray.pop())
    print("The array became:", linearArray)
    print("Use the index to remove the element:",linearArray.pop(1))
    print("The array became:", linearArray)
    print("=======================================")

    #del will remove the element by index
    del linearArray[3]
    print("Del operation:")
    print("The array became:", linearArray)
    print("=======================================")

    #insert, index and value
    linearArray.insert(1,0)
    print("Insert operation:")
    print("The array became:", linearArray)
    print("=======================================")

    #Search, using with if statement to identify whether there is a element
    #inside the array
    if 2 in linearArray:
        print("Element 2 is inside the array")
    print("=======================================")
    #search element with index
    print("The value of element of index 1 is:",linearArray.index(1))
    print("=======================================")

    #Change the value directly with the index
    linearArray[1]=9
    print("The array became:", linearArray)
    print("=======================================")

    #reverse
    #reverse() function has no return value, only change the order
    linearArray.reverse()
    print("The array after reversal: ", linearArray)
    print("=======================================")

    #Both sort and sorted with sort the order of the array
    #ascending sort by default
    #sort() has no return value
    #sorted() will create a new array
    #sort() only change the order of the original ones
    linearArray.sort()
    print("The array became:", linearArray)
    linearArray.sort(reverse=True)#descending sort
    print("The array became:", linearArray)
    sorted(linearArray)
    print("The array will not change:", linearArray)
    print("=======================================")

    #Interception
    '''
    a[start:stop:step]
    include the start but not the end
    step of 1 can be omitted 
    '''
    print(linearArray[0:5:1])
    print(linearArray[0:5:2])
    print(linearArray[0:5:3])

    #from right to left, step is negative
    print(linearArray[::-1])
    print("=======================================")

    '''
    使用python版本3.7
    python3.7中的下标，python下标有两套，一套是正的，一套是负的
    a='python'中的python 的下标可以如下
    组     p   y   t   h   o   n
    正下标 0   1   2   3   4   5
    负下标 -6 -5   -4  -3  -2  -1
    对应位置的 正下标 - 负下标=len(a)
    使用正下标时，下标i取值范围为0 <= i < len(a)     超出范围为越界
    使用负下标时，下标i取值范围为-1>= i >-len(a)-1   超出范围为越界
 
    数组操作中一般通过 “:” 和数字或变量的组合来灵活使用里面的元素
    “:” 一般表示循环
 
    a='python'
    b=a[1:4:1]  #结果为yth  。意思为从下标i个开始到下标j-1结束，步长为k，(k为整数且不能等于0)，第一个冒号满足左闭右开原则 。
                #当i，j出现异号时，可以全转换成正数去理解，负数中的出现-len(a)-1时，就不能转正数看待了，可以转换成负数去理解
                #k>0时，i默认为0，j默认为len(a) ; k<0时，i默认为-1，j默认为-len(a)-1，-len(a)-1只作为无法取到的边界，不可转正
    b=a[i]      #结果为y ,普通的数组访问，根据下标获取值
    b=a[i:j:-1] #结果为空
    b=a[4:0:-1] #结果为ohty
    b=a[4:-1:-1]#结果为空，可以理解为a[4:len(a)-1:-1]=a[4:5:-1]
    b=a[-1:0:-1]#结果为nohty,可以理解为a[5:0:-1]
    b=a[0:-1:1] #结果为pytho，可以理解为a[0:5:1]
    b=a[0:-1:-1]#结果为空 可以理解为a[0:5:-1]
    b=a[0:-2:-1]#结果为空  可以理解为a[0:4:-1]
    b=a[-2:0:-1]#结果为ohty,可以理解为a[4:0:-1]
    b=a[i:j]  #表示步长为1
    b=a[:j]   #结果为py 。i不写默认为0，j不写默认为len(a)
    b=a[i:]   #结果为ython，表示从下标i开始到最后一个（下标为len(a)-1）
    b=a[:]    #结果为python，表示从下标0开始到最后一个结束
    b=a[:-1]  #结果为pytho ，等价于a[0:5]
    b=a[::-1] #结果为nohtyp，等价于a[-1:-len(a)-1:-1]
    https://blog.csdn.net/qiushangren/article/details/103550923
    '''

    #clear the array
    linearArray.clear()
    print("The array became:",linearArray)
    print("=======================================")



def main():

    # doubleArray=[[1,0,2,4],[2,0,4,8]]
    # testArray=doubleArrayConstructor(3,4)
    # print(testArray)
    # some basic operations of Array
    arrayOperation()

if __name__ == "__main__":
    main()