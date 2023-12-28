# 链表中倒数第k个节点

## 一、题目描述
输入一个链表，输出该链表中倒数第 k 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6 。

这个链表的倒数第 3 个节点是值为 4 的节点。

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

## 二、题目解析
本题解题思路如下：

- 1、初始化两个指针 former 和 latter，一开始都指向链表的头节点
- 2、前指针 former 先向前走 k 步
- 3、两个指针 former 和 latter 同时向前移动，直到前指针 former 指向 NULL
- 4、最后返回 latter
